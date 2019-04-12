# Numerical Representations
Implementation of the representations for genomic sequences based mainly on Kwan, H.K. and Arniker, S.B., 2009
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
1. `SingleValueRepresentation` : a class to be inherited by all the one-dimensional representation classes. Contains a method to assign one numerical value to respective symbols
    - `AtomicNumberRepresentation` : numerical values assigned = atomic numbers of the nitrogenous bases (A, T, G, C)
    - `ElectronIonRepresentation` : numerical values assigned = electron-ion interaction potentials
    - `IntegerRepresentation` : numerical values assigned = integers 0-3
    - `RealNumberRepresentation` : numerical values assigned = opposite values for the bases in the pairs A-T and G-C
    - `PairedNumeric` : numerical values assigned = opposite values for the pairs A-T (+1) and G-C (-1)
    
    -All non-relevant characters to our analysis ("N") were assigned a fixed value of 0.0

2. `MultipleValueRepresentation` : a class to be inherited by all the multi-dimensional representation classes. Contains a method to assign multiple numerical values to each symbol
    - `Tetrahedron` : 3 numerical values assigned per symbol in the sequence
    - `Voss` : binary representation, 4 numerical values per symbol in the sequence
    - `PN Curve`: 16 possible pairs, 3 numerical values assigned per pair, taking into account the position on the sequence and the number of times each pair has appeared 
    - `TN Curve`: 64 possible possible triplets, 3 numerical values assigned per triplet, taking into ccount the number of times each triplet has appeared
    - `Z curve`: 3 numerical values per symbol
    - `Virtual Potentials`: 4 numerical values per symbol in the sequence, assigned on a rolling window basis
    
    -All non-relevant characters to our analysis ("N") were assigned a fixed value of 0.0
