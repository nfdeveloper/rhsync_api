package com.nfsystems.rhsync_api.marking.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MarkingResponse {
    private Long id;
    private Integer year;
    private Integer month;
    private Integer day;
    private Integer hour;
    private Integer minute;
    private String dateFormat;
    private String timeFormat;
    private String dateTimeFormat;
    private String statusMarking;

    public String getDateFormat(){
        return verifyStringNumber(this.day)+"/"+verifyStringNumber(this.month)+"/"+this.year;
    }

    public String getTimeFormat(){
        return verifyStringNumber(this.hour)+":"+verifyStringNumber(this.minute);
    }

    public String getDateTimeFormat(){
        return getDateFormat()+" "+getTimeFormat();
    }

    private String verifyStringNumber(Integer number){
        if(number < 10){
            return "0"+number;
        }
        return number.toString();
    }
}
