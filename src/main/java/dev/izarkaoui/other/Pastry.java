package dev.izarkaoui.other;

// Our base class :
public abstract class Pastry {
    abstract void accept(VisitorInterface visitor);
}

// types :
class Beignet extends  Pastry {

    @Override
    void accept(VisitorInterface visitor) {
        visitor.visitBeignet(this);
    }
}

class Culler extends Pastry {

    @Override
    void accept(VisitorInterface visitor) {
        visitor.visitCuller(this);
    }
}


// our visitor interface :
interface VisitorInterface {
    void visitBeignet(Beignet beignet);
    void visitCuller(Culler culler);
}

/* new operations on types are classes that implement the VisitorInterface: */

// to route to the right method based on the type we add the accept method (Polymorphism)


