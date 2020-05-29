package com.qa.service;

public interface Mapper<Source, Target> {

    Target mapToDTO(Source source);
}