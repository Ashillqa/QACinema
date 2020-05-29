package com.qa.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.dto.ShowTimeDTO;
import com.qa.domain.ShowTime;
import com.qa.service.ShowTimeService;

@RestController
@RequestMapping("/showTime")
public class ShowTimeController {

    private ShowTimeService service;

    @Autowired
    public ShowTimeController(ShowTimeService service) {
        super();
        this.service = service;
    }

    @PostMapping("/createShowTime")
    public ResponseEntity<ShowTimeDTO> createShowTime(@RequestBody ShowTime showTime) {
        return new ResponseEntity<ShowTimeDTO>(this.service.createShowTime(showTime), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteShowTime/{id}")
    public ResponseEntity<?> deleteShowTime(@PathVariable Long id) {
        return this.service.deleteShowTime(id) ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.noContent().build();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ShowTimeDTO> getShowTime(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.findShowTimeByID(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ShowTimeDTO>> getAllShowTimes() {
        return ResponseEntity.ok(this.service.readShowTimes());
    }

    @PutMapping("/updateShowTime")
    public ResponseEntity<ShowTimeDTO> updateShowTime(@PathParam("id") Long id, @RequestBody ShowTime showTime) {
        return new ResponseEntity<ShowTimeDTO>(this.service.updateShowTime(showTime, id), HttpStatus.ACCEPTED);
    }

}