package com.interviewsystem.services;

import com.interviewsystem.models.entity.Schedular;
import com.interviewsystem.models.requests.SchedularDto;
import com.interviewsystem.repository.SchedularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchedularService {

    @Autowired
    SchedularRepository schedularRepository;

    public List<SchedularDto> showSchedule(){


        List<Schedular> scheduledData = schedularRepository.findAll();
        List<SchedularDto> schedularDtos = new ArrayList<>();
        for(Schedular schedular : scheduledData){
            SchedularDto schedularDto = new SchedularDto(schedular.getScheduledDate(),
                    schedular.getSlot(), schedular.getCid(), schedular.getIid());

            schedularDtos.add(schedularDto);
        }

        return schedularDtos;
    }

}
