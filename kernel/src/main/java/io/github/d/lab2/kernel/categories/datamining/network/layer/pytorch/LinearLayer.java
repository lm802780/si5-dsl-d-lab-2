package io.github.d.lab2.kernel.categories.datamining.network.layer.pytorch;

import io.github.d.lab2.kernel.categories.datamining.network.layer.Layer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LinearLayer extends Layer {
    private int inFeatures;
    private int outFeatures;

}
