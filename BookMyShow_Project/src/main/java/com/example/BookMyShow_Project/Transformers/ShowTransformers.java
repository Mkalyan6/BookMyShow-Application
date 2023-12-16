package com.example.BookMyShow_Project.Transformers;

import com.example.BookMyShow_Project.Models.Show;
import com.example.BookMyShow_Project.RequestDTOs.AddShowRequest;

public class ShowTransformers {
    public static Show convertRequestToShow(AddShowRequest addShowRequest){
            Show show=Show.builder()
                    .showDate(addShowRequest.getShowDate())
                    .showTime(addShowRequest.getShowTime())
                    .build();
              return show;

    }
}
