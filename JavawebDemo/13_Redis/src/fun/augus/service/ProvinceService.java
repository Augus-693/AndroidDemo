package fun.augus.service;

import fun.augus.domain.Province;

import java.util.List;

public interface ProvinceService {
    public List<Province> findAll();
    public String findAllJson();
}
