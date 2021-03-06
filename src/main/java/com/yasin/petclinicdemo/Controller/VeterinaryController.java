package com.yasin.petclinicdemo.Controller;

import com.yasin.petclinicdemo.dto.VeterinaryDto;
import com.yasin.petclinicdemo.dto.converter.VeterinaryConverter;
import com.yasin.petclinicdemo.exception.NotFoundException;


import com.yasin.petclinicdemo.service.VeterinaryService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/veterinary")
public class VeterinaryController {

    private final VeterinaryConverter veterinaryConverter;
    private final VeterinaryService veterinaryService;

    public VeterinaryController(VeterinaryConverter veterinaryConverter, VeterinaryService veterinaryService) {
        this.veterinaryConverter = veterinaryConverter;
        this.veterinaryService = veterinaryService;
    }

    @GetMapping("/getAll")
    public List<VeterinaryDto> getAll(){
        return veterinaryService.getAll();
        //return veterinaryService.getAll();
    }

    @GetMapping(path = "/getId")
    public ResponseEntity<VeterinaryDto> getById(@RequestParam("id") Long id) throws NotFoundException {

//        Optional<Veterinary> veterinary = Optional.ofNullable(veterinaryService.getById(id)
//                .orElseThrow(() -> new NotFoundException("Data Bulunamadi")));
//        return Optional.ofNullable(veterinaryService.getById(id)
//                .orElseThrow(() -> new NotFoundException("Data Bulunamadi")));
        return ResponseEntity.ok(veterinaryConverter.convertToDto(veterinaryService.getById(id)));
    }

    @GetMapping(path = "/getName")
    public ResponseEntity<List<VeterinaryDto>> getByName(@RequestParam("name") String name)throws NotFoundException{
        return ResponseEntity.ok(veterinaryConverter.convertToDto(veterinaryService.getAllByName(name)));
    }


    @PostMapping("/add")
    public HttpStatus add(@RequestBody VeterinaryDto veterinary){
        veterinaryService.add(veterinary);
        return ResponseEntity.ok().build().getStatusCode();
//        if (ResponseEntity.ok(veterinary).getStatusCode() == HttpStatus.ACCEPTED){
//            return ResponseEntity.ok(veterinary).getStatusCode();
//        }else{
//            return ResponseEntity.ok().build().getStatusCode();
//        }
//        return HttpStatus

    }

    @PutMapping("/update")
    public HttpStatus update(@RequestParam("id") Long id, @RequestBody VeterinaryDto veterinaryDto){
        veterinaryService.update(id, veterinaryDto);
        return ResponseEntity.ok().build().getStatusCode();

    }


    @DeleteMapping(path = "/delete")
    public ResponseEntity<?> deleteByName(@RequestParam("name") String name){
        //return ResponseEntity.ok(veterinaryService.getByName(name));
        /*
         * todo
         * delete islemini isim veya soyisim ya da telefon numarasini aldiktan
         * sonra id dogrulamasi ile silinecek
         */

        VeterinaryDto veterinaryDto = veterinaryService.getByName(name);
        veterinaryService.deleteByName(name);


        return ResponseEntity.ok(veterinaryDto);


    }


}
