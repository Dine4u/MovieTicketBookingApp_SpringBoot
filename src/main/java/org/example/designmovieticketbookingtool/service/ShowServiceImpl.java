package org.example.designmovieticketbookingtool.service;

import org.example.designmovieticketbookingtool.exception.EntityNotPresentException;
import org.example.designmovieticketbookingtool.models.Show;
import org.example.designmovieticketbookingtool.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShowServiceImpl implements ShowService{
    private ShowRepository showRepository;

    @Autowired
    public ShowServiceImpl(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }
    @Override
    public Show getShow(int showid) {
//        Optional<Show> show = showRepository.findById(showid);
//        if(show.isPresent()){
//            return show.get();
//        }
//        throw new EntityNotPresentException("Show is not available in database");

        //Shortcut for above commented block,
        Show show=showRepository.findById(showid).orElseThrow(
                () -> new EntityNotPresentException("Show is not available in database")
                );

        return show;
    }
}
