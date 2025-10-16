package funciones;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import us.lsi.common.Pair;
import us.lsi.tiposrecursivos.BinaryTree;
import us.lsi.tiposrecursivos.Tree;
import us.lsi.tiposrecursivos.BinaryTree.BEmpty;
import us.lsi.tiposrecursivos.BinaryTree.BLeaf;
import us.lsi.tiposrecursivos.BinaryTree.BTree;
import us.lsi.tiposrecursivos.Tree.TEmpty;
import us.lsi.tiposrecursivos.Tree.TLeaf;
import us.lsi.tiposrecursivos.Tree.TNary;

public class Ejercicio3 {

	private static <E> Pair<Integer, Boolean> Binary(BinaryTree<E> tree, int alt, Boolean res) {
        return switch (tree) {
            case BEmpty<E> t -> Pair.of(0, true);
            case BLeaf<E> t -> Pair.of(0, true);
            case BTree<E> t -> {
                Pair<Integer, Boolean> right = Binary(t.right(), alt + 1, res);
                Pair<Integer, Boolean> left = Binary(t.left(), alt + 1, res);
                int a = Math.max(right.first(), left.first()) + 1;
                boolean b = Math.abs(right.first() - left.first()) <= 1;
                boolean c = right.second() && left.second();
                yield Pair.of(a, b && c);
            }
        };
    }
	public static <E> Boolean Binary(BinaryTree<E> tree) {
		return Binary(tree,0,true).second();
	}
	
	
	private static <E> Pair<Integer,Boolean> Nary(Tree<E> tree,Integer alt, Boolean res) {
	    return switch (tree) {
	        case TEmpty<E> t -> Pair.of(alt, res);
	        case TLeaf<E> t -> Pair.of(alt, res);
	        case TNary<E> t -> {
	        	List<Pair<Integer,Boolean>> list = t.children().stream()
	        			.map(child -> Nary(child,alt+1,res)).collect(Collectors.toList());
	        	IntSummaryStatistics stats = list.stream().mapToInt(p -> p.first()).summaryStatistics();
	        	Boolean a = list.stream().map(p -> p.second()).allMatch(pb -> pb == true) && stats.getMax() - stats.getMin() <= 1;
	            	yield  Pair.of(stats.getMax(), a);
	            }
	        };
	}
	public static <E> Boolean Nary(Tree<E> tree) {
		return Nary(tree,0,true).second();
	}

}
