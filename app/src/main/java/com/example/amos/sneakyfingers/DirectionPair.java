package com.example.amos.sneakyfingers;

/**
*
*/
class DirectionPair {
    public Direction first = Direction.NONE;
    public Direction second = Direction.NONE;

    DirectionPair(Direction d1, Direction d2) {
        first = d1;
        second = d2;
    }

    public boolean equals(Object obj) {
        //null instanceof Object will always return false
        if (!(obj instanceof DirectionPair))
            return false;
        if (obj == this)
            return true;
        return  (this.first == ((DirectionPair) obj).first) &&
                (this.second == ((DirectionPair) obj).second);
    }

    public int hashCode() {
        int code = 0;
        if (first != null)
            code += first.intCode() * 10;
        if (second != null)
            code += second.intCode();
        return code;
    }
}
