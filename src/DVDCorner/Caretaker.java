/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDCorner;

import java.util.Stack;
import java.util.Vector;

/**
 *
 * @author YipYi
 */
class Caretaker {

    Stack undoList = new Stack();
    Stack redoList = new Stack();

    void save(Vector _DVD, String info) {
        Memento mem = new Memento(_DVD, info);

        undoList.add(mem);
    }

    public void showUndoRedoList() {
        System.out.println();
        System.out.println("Undo List:");
        if (undoList.isEmpty()) {
            System.out.println("Empty");
        } else {
            for (int i = 0; i < undoList.size(); i++) {
                System.out.println(undoList.get(i));
            }
        }
        System.out.println();
        System.out.println("Redo List:");
        if (redoList.isEmpty()) {
            System.out.println("Empty");
        } else {
            for (int i = 0; i < redoList.size(); i++) {
                System.out.println(redoList.get(i));
            }
        }
        System.out.println();
    }

    void undo() {
        if (!undoList.isEmpty()) {
            Memento mem = (Memento) undoList.pop();
            mem.undo();
            redoList.push(mem);
        }else{
            System.out.println("Nothing to undo");
        }
    }

    void redo() {
        if (!redoList.isEmpty()) {
            Memento mem = (Memento) redoList.pop();
            mem.redo();
            undoList.push(mem);
        } else {
            System.out.println("Nothing to redo");
        }
    }

}
