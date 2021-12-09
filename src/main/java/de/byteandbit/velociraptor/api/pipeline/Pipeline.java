package de.byteandbit.velociraptor.api.pipeline;

import de.byteandbit.velociraptor.api.pipeline.PipelineElement;
import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

public class Pipeline {

    @Getter
    private List<PipelineElement> elements;

    public Pipeline() {
        elements = new LinkedList<>();
    }

    public void addElement(PipelineElement action) {
        elements.add(action);
    }
}
