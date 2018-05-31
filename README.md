# Numerical Representations
Implementation of the representations for genomic sequences based mainly on Mendizabal-Ruiz et al., 2017
## Interfaces
1. `ISymbolSequence`: represents an input sequence of symbols
    ### Methods to be implemented
    - `getExtendedInfo()` : Returns an additional information object, containing meta-data related to the sequence.
    - `getSymbolAt(index)` : Returns the symbol at the specific index position if the sequence.
    - `asString()` :  Returns a string representation of the sequence.
    - `size()` : Returns the size of the sequence.
 
 2. `IFeatureVector` : represents the output vector of a given input sequence
    ### Methods to be implemented
    - `getDimensionNames()` : Returns a list of the dimensions' names.
    - `getNumberOfDimensions()` : Returns an integer representing the number of dimensions.
    - `getDimensionValue(String dimensionName)` : Returns the value for a specific dimension.

## Base classes
1. `BaseSymbolSequence` : base class for the input symbol sequence. Implements the `ISymbolSequence` and contains all the necessary elements
to characterize a symbolic sequence

2. `BaseFeatureVector` : base class for the feature vector (output). Implements the `IFeatureVector`, contains all the necessary elements 
and extends TreeMap (matching name of dimension and value from `calculateVectorDimensions()` ).

## Classes depending on the dimensionality of the representations
1. `SingleValueRepresentation` : a class to be inherited by all the one-dimensional representation classes. Contains a method to assign one
value to respective symbols
    - `AtomicNumberRepresentation` : values assigned = atomic numbers of the nitrogenous bases (A, T, G, C)
    - `ElectronIonRepresentation` : values assigned = electron-ion interaction potentials
    - `IntegerRepresentation` : values assigned = integers 0-3
    - `RealNumberRepresentation` : values assigned = opposite values for the bases in the pairs A-T and G-C
    - `PairedNumeric` : values assigned = opposite values for the pairs A-T (+1) and G-C (-1)

2. `MultipleValueRepresentation` : a class to be inherited by all the multi-dimensional representation classes. Contains a method to 
assign multiple values to each symbol
    - `Tetrahedron` : 3 values assigned per symbol in the sequence
    - `Voss` : binary representation, 4 values per symbol in the sequence
