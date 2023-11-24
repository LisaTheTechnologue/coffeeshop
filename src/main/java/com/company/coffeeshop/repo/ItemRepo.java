package com.company.coffeeshop.repo;

import com.company.coffeeshop.entity.Item;
import com.company.coffeeshop.entity.ItemTag;
import com.company.coffeeshop.entity.user.Employee;
import io.jmix.core.repository.JmixDataRepository;
import io.jmix.core.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ItemRepo extends JmixDataRepository<Item, Long> {
    @Query("select i.tags from Item i where i.itemId = :itemId")
    List<ItemTag> getItemTagsByItemId(Long itemId);

}
