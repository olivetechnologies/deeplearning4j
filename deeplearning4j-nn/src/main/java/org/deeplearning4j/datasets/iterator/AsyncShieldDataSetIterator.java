package org.deeplearning4j.datasets.iterator;


import lombok.NonNull;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.dataset.api.DataSetPreProcessor;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;

import java.util.List;

/**
 * This wrapper takes your existing DataSetIterator implementation and prevents asynchronous prefetch
 *
 * @author raver119@gmail.com
 */
public class AsyncShieldDataSetIterator implements DataSetIterator {
    private DataSetIterator backingIterator;

    public AsyncShieldDataSetIterator(@NonNull DataSetIterator iterator) {
        this.backingIterator = iterator;
    }

    /**
     * Like the standard next method but allows a
     * customizable number of examples returned
     *
     * @param num the number of examples
     * @return the next data applyTransformToDestination
     */
    @Override
    public DataSet next(int num) {
        return backingIterator.next(num);
    }

    /**
     * Total examples in the iterator
     *
     * @return
     */
    @Override
    public int totalExamples() {
        return backingIterator.totalExamples();
    }

    /**
     * Input columns for the dataset
     *
     * @return
     */
    @Override
    public int inputColumns() {
        return backingIterator.inputColumns();
    }

    /**
     * The number of labels for the dataset
     *
     * @return
     */
    @Override
    public int totalOutcomes() {
        return backingIterator.totalOutcomes();
    }

    /**
     * Is resetting supported by this DataSetIterator? Many DataSetIterators do support resetting,
     * but some don't
     *
     * @return true if reset method is supported; false otherwise
     */
    @Override
    public boolean resetSupported() {
        return backingIterator.resetSupported();
    }

    /**
     * Does this DataSetIterator support asynchronous prefetching of multiple DataSet objects?
     *
     * PLEASE NOTE: This iterator ALWAYS returns FALSE
     *
     * @return true if asynchronous prefetching from this iterator is OK; false if asynchronous prefetching should not
     * be used with this iterator
     */
    @Override
    public boolean asyncSupported() {
        return false;
    }

    /**
     * Resets the iterator back to the beginning
     */
    @Override
    public void reset() {
        backingIterator.reset();
    }

    /**
     * Batch size
     *
     * @return
     */
    @Override
    public int batch() {
        return backingIterator.batch();
    }

    /**
     * The current cursor if applicable
     *
     * @return
     */
    @Override
    public int cursor() {
        return backingIterator.cursor();
    }

    /**
     * Total number of examples in the dataset
     *
     * @return
     */
    @Override
    public int numExamples() {
        return backingIterator.numExamples();
    }

    /**
     * Set a pre processor
     *
     * @param preProcessor a pre processor to set
     */
    @Override
    public void setPreProcessor(DataSetPreProcessor preProcessor) {
        backingIterator.setPreProcessor(preProcessor);
    }

    /**
     * Returns preprocessors, if defined
     *
     * @return
     */
    @Override
    public DataSetPreProcessor getPreProcessor() {
        return backingIterator.getPreProcessor();
    }

    /**
     * Get dataset iterator record reader labels
     */
    @Override
    public List<String> getLabels() {
        return backingIterator.getLabels();
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        return backingIterator.hasNext();
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     */
    @Override
    public DataSet next() {
        return backingIterator.next();
    }

    /**
     * Removes from the underlying collection the last element returned
     * by this iterator (optional operation).  This method can be called
     * only once per call to {@link #next}.  The behavior of an iterator
     * is unspecified if the underlying collection is modified while the
     * iteration is in progress in any way other than by calling this
     * method.
     *
     * @throws UnsupportedOperationException if the {@code remove}
     *                                       operation is not supported by this iterator
     * @throws IllegalStateException         if the {@code next} method has not
     *                                       yet been called, or the {@code remove} method has already
     *                                       been called after the last call to the {@code next}
     *                                       method
     * @implSpec The default implementation throws an instance of
     * {@link UnsupportedOperationException} and performs no other action.
     */
    @Override
    public void remove() {
        // no-op
    }
}
