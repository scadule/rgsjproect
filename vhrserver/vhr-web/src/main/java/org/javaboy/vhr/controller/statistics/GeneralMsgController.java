package org.javaboy.vhr.controller.statistics;

import org.javaboy.vhr.model.Employeetrain;
import org.javaboy.vhr.model.RespMsgBean;
import org.javaboy.vhr.model.RespPageBean;
import org.javaboy.vhr.service.GeneralMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/statistics/generalmsg")
public class GeneralMsgController {

    @Autowired
    GeneralMsgService generalMsgService;

    @GetMapping("/department")
    public List<RespMsgBean> getDepartmentNumber() {
        return generalMsgService.getDepartmentNumber();
    }

    @GetMapping("/degree")
    public List<RespMsgBean> gettiptopDegreeNumber() {
        return generalMsgService.gettiptopDegreeNumber();
    }

    @GetMapping("/position")
    public List<RespMsgBean> getPositionNumber() {
        return generalMsgService.getPositionNumber();
    }

    @GetMapping("/nativeplace")
    public List<RespMsgBean> getnativePlaceNumber() {
        return generalMsgService.getnativePlaceNumber();
    }

}
