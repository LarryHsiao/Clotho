package com.larryhsiao.clotho.paginations;

import java.util.List;

public interface Pagination<T> {
    List<T> nextPage();
}
