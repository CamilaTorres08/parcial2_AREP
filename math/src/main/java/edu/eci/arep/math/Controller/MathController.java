package edu.eci.arep.math.Controller;

import edu.eci.arep.math.Model.Response;
import edu.eci.arep.math.Service.MathService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @GetMapping("/binarySearch")
    public ResponseEntity<?> binarySearch(@RequestParam int value, @RequestParam String list){
        MathService service = new MathService();
        String[] numberList = list.split(",");
        int result = service.binarySearch(value, numberList, 0, numberList.length -1);
        return ResponseEntity.ok(new Response("binarySearch",list,value,result));
    }

    @GetMapping("/linearSearch")
    public ResponseEntity<?> linearSearch(@RequestParam int value, @RequestParam String list){
        MathService service = new MathService();
        String[] numberList = list.split(",");
        int result = service.linearSearch(value, numberList);
        return ResponseEntity.ok(new Response("linearSearch",list,value,result));
    }
}
