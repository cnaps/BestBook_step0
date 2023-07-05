package com.infrean.BestBookMS.domain.model;

import com.infrean.BestBookMS.domain.model.vo.Item;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class BestBook {

  @Id
    private String id;

    private Item item;
    private Long rentCount;

    public static BestBook registerBestBook(Item item){
        var bestBook = new BestBook();
        bestBook.setItem(item);
        bestBook.setRentCount(1L);
        return bestBook;
    }

    public Long increseBestBookCount(){
        return  this.getRentCount() + 1;
    }
}
