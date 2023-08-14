package com.msa.BestBookMS.domain.model;

import com.msa.BestBookMS.domain.model.vo.Item;
import lombok.*;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class BestBook {

static UUID uuid = UUID.randomUUID();

@Id
private String id;

private Item item;
private Long rentCount;

public static BestBook registerBestBook(Item item){
    var bestBook = new BestBook();
    bestBook.setId(uuid.toString());
    bestBook.setItem(item);
    bestBook.setRentCount(1L);
    return bestBook;
}

public Long increseBestBookCount(){
        return  this.getRentCount() + 1;
    }
}
