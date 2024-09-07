package org.dyu5thdorm.dyu5thdormapi.scheduling;

import com.github.nutt1101.DormDataApi;
import com.github.nutt1101.models.Dormitory;
import com.github.nutt1101.models.LoginParameters;
import com.github.nutt1101.models.RequestParameters;
import jakarta.annotation.PostConstruct;
import org.dyu5thdorm.dyu5thdormapi.models.Bed;
import org.dyu5thdorm.dyu5thdormapi.models.LivingRecord;
import org.dyu5thdorm.dyu5thdormapi.models.SchoolTimestamp;
import org.dyu5thdorm.dyu5thdormapi.models.Student;
import org.dyu5thdorm.dyu5thdormapi.repositories.BedRepository;
import org.dyu5thdorm.dyu5thdormapi.repositories.LivingRecordRepository;
import org.dyu5thdorm.dyu5thdormapi.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
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

    private final StudentRepository studentRepository;
    private final BedRepository bedRepository;
    private final LivingRecordRepository livingRecordRepository;
    private LoginParameters loginParameters;
    private RequestParameters requestParameters;

    public AutoUpdateDatabase(StudentRepository studentRepository, BedRepository bedRepository, LivingRecordRepository livingRecordRepository) {
        this.studentRepository = studentRepository;
        this.bedRepository = bedRepository;
        this.livingRecordRepository = livingRecordRepository;
    }

    @PostConstruct
    void setup() {
        this.loginParameters = LoginParameters.builder()
                .account(id)
                .password(password)
                .build();
        this.requestParameters = RequestParameters.builder()
                .semesterYear(s_smye)
                .semester(s_smty)
                .dormitory(Dormitory.Diligent)
                .build();
        this.update();
    }

    @Scheduled(cron = "${update.time}")
    void update() {
        try {

            List<com.github.nutt1101.models.Bed> data = DormDataApi.getBedData(
                    this.loginParameters, this.requestParameters
            );

            for (com.github.nutt1101.models.Bed datum : data) {
                System.out.println(datum);
                Bed bed = new Bed();
                bed.setBedId(datum.getId());
                bedRepository.save(bed);

                Student student = null;
                if (datum.getStudent() != null) {
                    student = new Student(
                            datum.getStudent()
                    );
                    studentRepository.save(student);
                }

                SchoolTimestamp schoolTimestamp = new SchoolTimestamp();
                schoolTimestamp.setSchoolYear(Integer.valueOf(s_smye));
                schoolTimestamp.setSemester(Integer.valueOf(s_smty));

                LivingRecord livingRecord = new LivingRecord();
                livingRecord.setBed(bed);
                livingRecord.setStudent(student);
                livingRecord.setSchoolTimestamp(schoolTimestamp);
                livingRecordRepository.save(livingRecord);
            }

            System.out.printf("{y: %s, s: %s, t: %s} => OK%n", s_smye, s_smty, dateFormat.format(new Date()));
        } catch (IOException e) {
            System.out.printf("{y: %s, s: %s, t: %s} => ERROR%n", s_smye, s_smty, dateFormat.format(new Date()));
            throw new RuntimeException(e);
        }
    }
}
