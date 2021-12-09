package de.byteandbit.velociraptor.api.pipeline.actions;

import de.byteandbit.velociraptor.Velociraptor;
import de.byteandbit.velociraptor.api.pipeline.PipelineAction;
import de.byteandbit.velociraptor.transaction.transactions.Transaction;
import lombok.AllArgsConstructor;

import java.util.function.Consumer;

@AllArgsConstructor
public class PipelineUpdateTransactionAction extends PipelineAction {

    private Transaction transaction;
    private Consumer<Transaction> updateFunction;

    @Override
    public void execute() {
        updateFunction.accept(transaction);
        Velociraptor.getInstance().getTransactionManager().save(transaction);
    }
}
