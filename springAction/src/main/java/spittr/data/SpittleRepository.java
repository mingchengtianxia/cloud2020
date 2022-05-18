package spittr.data;

import java.util.List;

public interface SpittleRepository {
    List<Spittle> findSpittes(long max, int count);

    Spittle findOne(long id);

    void save(Spitter spitter);

    public Spitter findByUsername(String username);
}
