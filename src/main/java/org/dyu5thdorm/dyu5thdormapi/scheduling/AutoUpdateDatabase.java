package org.dyu5thdorm.dyu5thdormapi.scheduling;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.dyu5thdorm.RoomDataFetcher.RoomDataFetcher;
import org.dyu5thdorm.RoomDataFetcher.models.DataFetchingParameter;
import org.dyu5thdorm.RoomDataFetcher.models.Room;
import org.dyu5thdorm.dyu5thdormapi.models.Bed;
import org.dyu5thdorm.dyu5thdormapi.models.LivingRecord;
import org.dyu5thdorm.dyu5thdormapi.models.SchoolTimestamp;
import org.dyu5thdorm.dyu5thdormapi.models.Student;
import org.dyu5thdorm.dyu5thdormapi.repositories.BedRepository;
import org.dyu5thdorm.dyu5thdormapi.repositories.LivingRecordRepository;
import org.dyu5thdorm.dyu5thdormapi.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@PropertySource("classpath:setting.properties")
public class AutoUpdateDatabase {

    @Value("${date.format}")
    private SimpleDateFormat dateFormat;
    @Value("${login.id}")
    private String id;
    @Value("${login.password}")
    private String password;
    @Value("${fetch.s_smye}")
    private String s_smye;
    @Value("${fetch.s_smty}")
    private String s_smty;

    @Autowired private StudentRepository studentRepository;
    @Autowired private BedRepository bedRepository;
    @Autowired private LivingRecordRepository livingRecordRepository;


    @Scheduled(fixedRateString = "${update.time}")
    void update() {
        try {
            List<Room> data = RoomDataFetcher.getData(
                    new DataFetchingParameter(id, password, s_smye, s_smty)
            );

            for (Room datum : data) {
                Bed bed = new Bed();
                bed.setBedId(datum.roomId());
                bedRepository.save(bed);

                Student student = null;
                if (datum.student() != null) {
                    student = new Student(
                            datum.student()
                    );
                    studentRepository.save(student);
                }

                String time = datum.dataTime();
                SchoolTimestamp schoolTimestamp = new SchoolTimestamp();
                schoolTimestamp.setSchoolYear(Integer.valueOf(s_smye));
                schoolTimestamp.setSemester(Integer.valueOf(s_smty));

                LivingRecord livingRecord = new LivingRecord();
                livingRecord.setBed(bed);
                livingRecord.setStudent(student);
                livingRecord.setSchoolTimestamp(schoolTimestamp);
                livingRecord.setUpdateTime(time.isEmpty() ? null : dateFormat.parse(time));
                livingRecordRepository.save(livingRecord);
            }

            System.out.println(dateFormat.format(new Date()) + " updated...");
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
