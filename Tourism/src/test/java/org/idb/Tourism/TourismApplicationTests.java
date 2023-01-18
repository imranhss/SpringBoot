package org.idb.Tourism;

import net.bytebuddy.build.ToStringPlugin;
import org.idb.Tourism.entity.Hotel;
import org.idb.Tourism.entity.Inventory;
import org.idb.Tourism.service.HotelService;
import org.idb.Tourism.service.InventoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TourismApplicationTests {
	@Autowired
	HotelService hotelService;






	@Test
	void contextLoads() {
	}

	@Test
	void  saveHotel(){

		Hotel h = new Hotel();


				h.setHname("RomanHotel");
				h.setHemail("abc@gmail.com");
				h.setHpassword("1234");
				h.setHphone("01857459018");

		hotelService.saveHotel(h);

	}





	@Autowired
	InventoryService inv;

	@Test
	void saveInven(){
		Inventory i = new Inventory();
		i.setIstartDate("jdjfhjd");
		i.setIendDate("fffff");
		inv.saveinventory(i);
	}

	@Test
	void getByIDInven(){
		System.out.println(inv.findHotelById(1));

	}
	@Test
	void deleteInvenByID(){
		inv.deleteinventoryById(1);
	}

	@Test
	void x(){
		System.out.println(hotelService.getHotelListByLocation(2));
	}
}
