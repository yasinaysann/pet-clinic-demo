package com.yasin.petclinicdemo.Controller;

import com.yasin.petclinicdemo.dto.VeterinaryDto;
import com.yasin.petclinicdemo.dto.convert.VeterinaryConvert;
import com.yasin.petclinicdemo.exception.NotFoundException;
import com.yasin.petclinicdemo.model.Veterinary;
import com.yasin.petclinicdemo.service.VeterinaryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/api/v1/veterinary")

public class VeterinaryController {

    private final VeterinaryConvert veterinaryConvert;
    private final VeterinaryService veterinaryService;

    public VeterinaryController(VeterinaryConvert veterinaryConvert, VeterinaryService veterinaryService) {
        this.veterinaryConvert = veterinaryConvert;
        this.veterinaryService = veterinaryService;
    }

    @GetMapping("/getAll")
    public List<VeterinaryDto> getAll(){
        return veterinaryConvert.convertToDto(veterinaryService.getAll());
        //return veterinaryService.getAll();
    }

    @GetMapping(path = "/getId")
    public ResponseEntity<VeterinaryDto> getById(@RequestParam("id") Long id) throws NotFoundException {

//        Optional<Veterinary> veterinary = Optional.ofNullable(veterinaryService.getById(id)
//                .orElseThrow(() -> new NotFoundException("Data Bulunamadi")));
//        return Optional.ofNullable(veterinaryService.getById(id)
//                .orElseThrow(() -> new NotFoundException("Data Bulunamadi")));
        return ResponseEntity.ok(veterinaryConvert.convertToDto(veterinaryService.getById(id)));
    }

    @GetMapping(path = "/getName")
    public ResponseEntity<List<VeterinaryDto>> getByName(@RequestParam("name") String name)throws NotFoundException{
        return ResponseEntity.ok(veterinaryConvert.convertToDto(veterinaryService.getAllByName(name)));
    }


    @PostMapping("/add")
    public ResponseEntity<Veterinary> add(@RequestBody Veterinary veterinary){
        veterinaryService.add(veterinary);
        return ResponseEntity.ok(veterinary);
//        if (ResponseEntity.ok(veterinary).getStatusCode() == HttpStatus.ACCEPTED){
//            return ResponseEntity.ok(veterinary).getStatusCode();
//        }else{
//            return ResponseEntity.ok().build().getStatusCode();
//        }
//        return HttpStatus

    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<HttpStatus> deleteByName(@RequestParam("name") String name){
        //return ResponseEntity.ok(veterinaryService.getByName(name));
        /*
         * todo
         * delete islemini isim veya soyisim ya da telefon numarasini aldiktan
         * sonra id dogrulamasi ile silinecek
         */
        veterinaryService.deleteByName(name);
        return ResponseEntity.ok().build();

    }


}
