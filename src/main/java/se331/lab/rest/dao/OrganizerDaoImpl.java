package se331.lab.rest.dao;

import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Organizer;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Repository
public class OrganizerDaoImpl implements OrganizerDao{
    List<Organizer> organizerList;

    @PostConstruct
    public void init() {
        organizerList = new ArrayList<>();
        organizerList.add(Organizer.builder()
                .id(1L)
                .name("Edmund Downs")
                .address("3653 Black Oak Hollow Road")
                .build());
        organizerList.add(Organizer.builder()
                .id(2L)
                .name("Russell Pace")
                .address("3215 Giraffe Hill Drive")
                .build());
        organizerList.add(Organizer.builder()
                .id(3L)
                .name("Oscar Conner")
                .address("3558 Kembery Drive")
                .build());
        organizerList.add(Organizer.builder()
                .id(4L)
                .name("Ballard Hobbs")
                .address("2698 Mutton Town Road")
                .build());
        organizerList.add(Organizer.builder()
                .id(5L)
                .name("Hayes Tate")
                .address("3653 Black Oak Hollow Road")
                .build());
        organizerList.add(Organizer.builder()
                .id(6L)
                .name("Weaver Mcbride")
                .address("4415 Fleming Street")
                .build());
    }

    @Override
    public Integer getOrganizerSize() {
        return organizerList.size();
    }

    @Override
    public List<Organizer> getOrganizers(Integer pageSize, Integer page) {
        pageSize = pageSize == null?organizerList.size() : pageSize;
        page = page == null?1 : page;
        int firstIndex = (page - 1) * pageSize;
        return organizerList.subList(firstIndex, firstIndex + pageSize);
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizerList.stream().filter(organizer -> organizer.getId().equals(id)).findFirst().orElse(null);
    }
}
