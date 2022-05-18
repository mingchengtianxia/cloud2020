package spittr.data;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.*;

/**
 * @author mingchengtianxia
 * @date 2022/5/18--9:49
 */
@Repository
public class JdbcSpittleRepository implements SpittleRepository {

	@PostConstruct
	public void init(){
		for(int i=0;i<30;i++){
			double longitude = i+0.2;
			Spittle spittle = new Spittle((long)i,"a", LocalDate.now(),1.2,longitude);
			spittleMap.put((long)i, spittle);
		}
	}

	Map<Long, Spittle> spittleMap = new HashMap<>();
	Map<String, Spitter> spitterMap = new HashMap<>();

	public List<Spittle> findRecentSpittles() {
		ArrayList<Spittle> list = new ArrayList<>();
		list.addAll(spittleMap.values());
		return list;
	}

	public List<Spittle> findSpittes(long max, int count) {
		ArrayList<Spittle> list = new ArrayList<>();
		Object[] values = spittleMap.values().toArray();
		for(int i=0;i<count;i++){
			list.add((Spittle)values[i]);
		}
		return list;
	}

	public Spittle findOne(long id) {
		return spittleMap.get(id);
	}

	public void save(Spittle spittle) {
		spittleMap.put(spittle.getId(), spittle);
	}

	public Spittle newSpittle(){
		Spittle spittle = new Spittle("a", LocalDate.now());
		return spittle;
	}

	public void save(Spitter spitter){
		spitterMap.put(spitter.getUsername(), spitter);
	}

	public Spitter findByUsername(String username){
		return spitterMap.get(username);
	}
}
