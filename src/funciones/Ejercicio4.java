package funciones;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import us.lsi.tiposrecursivos.BinaryTree;
import us.lsi.tiposrecursivos.BinaryTree.BEmpty;
import us.lsi.tiposrecursivos.BinaryTree.BLeaf;
import us.lsi.tiposrecursivos.BinaryTree.BTree;
import us.lsi.tiposrecursivos.Tree;
import us.lsi.tiposrecursivos.Tree.TEmpty;
import us.lsi.tiposrecursivos.Tree.TLeaf;
import us.lsi.tiposrecursivos.Tree.TNary;

public class Ejercicio4 {

	private static List<List<String>> BinaryAux(BinaryTree<String> tree) {
		List<List<String>> a = switch (tree) {
		case BEmpty<String> t -> List.of(List.of("_"));
		case BLeaf<String> t -> {
			String l = t.label();
			List<String> ls = new ArrayList<>();
			ls.add(l);
			yield List.of(ls);
		}
		case BTree<String> t -> {
			List<List<String>> leftPaths = BinaryAux(t.left());
			List<List<String>> rightPaths = BinaryAux(t.right());
			String l = t.label();
			List<List<String>> paths = new ArrayList<>();
			for (List<String> path : leftPaths) {
				List<String> newPath = new ArrayList<>();
				newPath.add(l);
				newPath.addAll(path);
				paths.add(newPath);
			}
			for (List<String> path : rightPaths) {
				List<String> newPath = new ArrayList<>();
				newPath.add(l);
				newPath.addAll(path);
				paths.add(newPath);
			}
			yield paths;
			}
		};
		return a;
	}

	private static List<List<String>> filterPaths(List<List<String>> paths) {
		List<List<String>> filteredPaths = new ArrayList<>();
		for (List<String> path : paths) {
			int sum = path.stream().filter(s -> s.matches("-?\\d+")).mapToInt(Integer::parseInt).sum();
			if (path.size() > 1 && sum % (path.size() - 1) == 0) {
				List<String> filteredPath = new ArrayList<>(path);
				filteredPaths.add(filteredPath);
			}
		}
		return filteredPaths;
	}

	private static List<List<String>> NaryAux(Tree<String> tree) {
		return switch (tree) {
		case TEmpty<String> t -> List.of();
		case TLeaf<String> t -> {
			String l = t.label();
			List<String> ls = new ArrayList<>();
			ls.add(l);
			yield List.of(ls);
		}
		case TNary<String> t -> {
			List<List<String>> paths = new ArrayList<>();
			List<List<String>> childPaths = t.children().stream().flatMap(child -> NaryAux(child).stream())
					.collect(Collectors.toList());

			String l = t.label();
			for (List<String> path : childPaths) {
				List<String> newPath = new ArrayList<>();
				newPath.add(l);
				newPath.addAll(path);
				paths.add(newPath);
			}

			yield paths;
			}
		};
	}

	public static List<List<String>> Binary(BinaryTree<String> tree) {
		return filterPaths(BinaryAux(tree));
	}

	public static List<List<String>> Nary(Tree<String> tree) {
		return filterPaths(NaryAux(tree));
	}

}