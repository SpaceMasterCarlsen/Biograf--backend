package biograf.service;

import biograf.model.ShowTime;
import biograf.repositories.ShowTimeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ShowTimeService {

    private ShowTimeRepository showTimeRepository;

    public ShowTimeService (ShowTimeRepository showTimeRepository){
        this.showTimeRepository = showTimeRepository;
    }

    public List<ShowTime> getAllShowTime() {
        return showTimeRepository.findAll();
    }

    public Optional<ShowTime> getShowTimeById(int id) {
        return showTimeRepository.findById(id);
    }

    public ShowTime saveShowTime(ShowTime showTime) {
        return showTimeRepository.save(showTime);
    }

    public void deleteShowTime(int id) {
        showTimeRepository.deleteById(id);
    }

    public List<ShowTime> findByDate(LocalDate date) {
        return showTimeRepository.findByDate(date);
    }
}
