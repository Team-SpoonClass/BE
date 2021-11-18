package com.likelion.spoonclass.common.dto;

public class ResponseOnlyIdDto extends BaseDto {
    private Long id;

    private ResponseOnlyIdDto(Long id,String message){
        super(message);
        this.id = id;
    }

    public static ResponseOnlyIdDto of(Long id,String message){
        return new ResponseOnlyIdDto(id,message);
    }
}
