package repositories;

public class BaseRepository {
    Long curId;

    public Long getNextId() {
        return this.curId + 1;
    }

    public void setNextId(Long id) {
        this.curId = id;
    }

}
