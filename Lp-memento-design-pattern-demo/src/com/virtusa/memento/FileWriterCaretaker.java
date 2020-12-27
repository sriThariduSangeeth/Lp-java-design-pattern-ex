package com.virtusa.memento;

/**
 * @author dtsangeeth
 * @created 27 / 12 / 2020
 * @project Lp-memento-design-pattern-demo
 */
public class FileWriterCaretaker {

    private Object obj;

    public void save(FileWriterUtil fileWriter){
        this.obj=fileWriter.save();
    }

    public void undo(FileWriterUtil fileWriter){
        fileWriter.undoToLastSave(obj);
    }

}
