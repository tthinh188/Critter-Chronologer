package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.entity.Schedule;
import com.udacity.jdnd.course3.critter.repository.CustomerRepository;
import com.udacity.jdnd.course3.critter.repository.EmployeeRepository;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import com.udacity.jdnd.course3.critter.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public List<Schedule> getAllSchedulesForPet(Long petId) {
        return scheduleRepository.getAllByPetId(petId);
    }

    public List<Schedule> getScheduleForEmployee(Long employeeId) {
        return scheduleRepository.getAllByEmployeesId(employeeId);
    }

    public List<Schedule> getScheduleForCustomer(Long customerId) {
        return scheduleRepository.getAllByCustomerId(customerId);
    }

    public Schedule saveSchedule(Schedule schedule, List<Long> employeeId, List<Long> petId) {
        schedule.setEmployees(employeeRepository.findAllById(employeeId));
        schedule.setPets(petRepository.findAllById(petId));
        return scheduleRepository.save(schedule);
    }
}
