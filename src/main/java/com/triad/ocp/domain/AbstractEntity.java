package com.triad.ocp.model;

import javax.persistence.Id;
import java.io.Serializable;

public class AbstractEntity implements Serializable {

    @Id
    private Long id;
}
