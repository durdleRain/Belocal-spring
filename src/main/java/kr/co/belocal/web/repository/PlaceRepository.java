package kr.co.belocal.web.repository;

import org.apache.ibatis.annotations.Mapper;

import kr.co.belocal.web.entity.Place;

@Mapper
public interface PlaceRepository {
    int save(Place place);
}