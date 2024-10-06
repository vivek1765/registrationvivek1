package com.api.service;

import com.api.entity.Registration;
import com.api.exception.ResourceNotFoundException;
import com.api.payload.RegistrationDto;
import com.api.repository.RegistrationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrationService {

    private RegistrationRepository registrationRepository;
    private ModelMapper modelMapper;
    public RegistrationService(RegistrationRepository registrationRepository, ModelMapper modelMapper) {
        this.registrationRepository = registrationRepository;
        this.modelMapper = modelMapper;
    }

    public List<RegistrationDto> getRegistration() {
        List<Registration> registrations = registrationRepository.findAll();
        List<RegistrationDto> dtos =registrations.stream().map(r->mapToDto(r)).collect(Collectors.toList());
        return dtos;


    }

    public RegistrationDto createRegistration(RegistrationDto registrationDto) {

      // copy dto to entity


             Registration registration=mapToEntity(registrationDto);
        Registration savedEntity = registrationRepository.save(registration);

        //copy entity to dto

        RegistrationDto dto = mapToDto(savedEntity);
        return dto;
    }

    public void deleteRegistration(Long id) {
        registrationRepository.deleteById(id);
    }

    public Registration updateRegistration(long id, Registration registration) {
        Registration r = registrationRepository.findById(id).get();
        r.setEmail(registration.getEmail());
        r.setEmail(registration.getEmail());
        r.setMobile(registration.getMobile());
        Registration savedEntity = registrationRepository.save(r);
         return savedEntity;

    }

 Registration mapToEntity(RegistrationDto  registrationDto){
   Registration registration =     modelMapper.map(registrationDto,Registration.class);
//     Registration registration = new Registration();
//     registration.setName(registrationDto.getName());
//     registration.setEmail(registrationDto.getEmail());
//     registration.setMobile(registrationDto.getMobile());
     return registration;

}
      RegistrationDto mapToDto(Registration registration){
     RegistrationDto dto = modelMapper.map(registration, RegistrationDto.class);
//          RegistrationDto dto= new RegistrationDto();
//          dto.setName(registration.getName());
//          dto.setEmail(registration.getEmail());
//          dto.setMobile(registration.getMobile());
          return dto;

       }

    public RegistrationDto getRegistrationById(long id) {
        Registration registration = registrationRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Record not found")
        );
       return   mapToDto(registration);
    }
}

