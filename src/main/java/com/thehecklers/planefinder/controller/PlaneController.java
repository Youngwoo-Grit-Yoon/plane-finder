package com.thehecklers.planefinder.controller;

import com.thehecklers.planefinder.service.PlaneFinderService;
import com.thehecklers.planefinder.domain.Aircraft;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class PlaneController {
    private final PlaneFinderService pfService;

    public PlaneController(PlaneFinderService pfService) {
        this.pfService = pfService;
    }

    @ResponseBody
    @GetMapping("/aircraft")
    public Iterable<Aircraft> getCurrentAircraft() throws IOException {
        return pfService.getAircraft();
    }

    @ResponseBody
    @GetMapping("/aircraft/list")
    public List<Aircraft> getAircraftList() throws IOException {
        Iterator<Aircraft> iterator = pfService.getAircraft().iterator();
        List<Aircraft> list = new ArrayList<>();

        while (iterator.hasNext()) {
            list.add(iterator.next());
        }

        return list;
    }
}
