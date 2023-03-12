package Book_My_Application.Home.Conventor;

import Book_My_Application.Home.DTOs.ShowDTOs;
import Book_My_Application.Home.Entity.ShowEntity;

public class ShowConventor {

    public static ShowEntity convertShowDtoIntoEntity(ShowDTOs showDTOs){
        ShowEntity showEntity= ShowEntity.builder().showDate(showDTOs.getLocalDate())
                .showTime(showDTOs.getLocalTime())
                .showType(showDTOs.getShowType()).build();
        return showEntity;
    }
}
