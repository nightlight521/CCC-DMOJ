import java.io.*;
import java.util.*;

class GatesOriginalAVLTree {
    public static interface IntSet {
        // Adds `i` if not already present. Returns whether or not `i` was added.
        public boolean add(Integer i);

        // Removes `i` if it is present. Returns whether or not `i` was removed.
        public boolean remove(Integer i);

        // Returns the greatest element less than or equal to `i`, or null if
        // there is no such element.
        public Integer floor(Integer i);
    }

    public static class IntBST implements IntSet {
        private static class Node {
            Node left = null;
            Node right = null;
            Integer value;
            Node parent;
            int heightDelta = 0; // left - right

            Node(Integer value, Node parent) {
                this.value = value;
                this.parent = parent;
            }

            void replaceChild(Node toReplace, Node replacement) {
                assert left != null || right != null;
                if (left == toReplace) {
                    left = replacement;
                } else if (right == toReplace) {
                    right = replacement;
                } else {
                    assert false;
                }
                if (replacement != null) {
                    replacement.parent = toReplace.parent;
                }
            }
        }
        private Node root;

        void leftRotate(Node toRotate) {
            Node toSwap = toRotate.right;
            toRotate.replaceChild(toSwap, toSwap.left);
            toSwap.left = toRotate;
            if (toRotate.parent != null) {
                toRotate.parent.replaceChild(toRotate, toSwap);
            } else {
                root = toSwap;
                root.parent = null;
            }
            toRotate.parent = toSwap;
        }

        void rightRotate(Node toRotate) {
            Node toSwap = toRotate.left;
            toRotate.replaceChild(toSwap, toSwap.right);
            toSwap.right = toRotate;
            if (toRotate.parent != null) {
                toRotate.parent.replaceChild(toRotate, toSwap);
            } else {
                root = toSwap;
                root.parent = null;
            }
            toRotate.parent = toSwap;
        }

        // Given the parent of a just-deleted node and the replacement child,
        // rebalances the whole tree and adjusts the height differences.
        private void rebalanceRemove(Node parent, Node newChild) {
            while (parent != null) {
                if (parent.left == null && parent.right == null) {
                    parent.heightDelta = 0;
                } else if (parent.left == newChild) {
                    parent.heightDelta -= 1;
                } else if (parent.right == newChild) {
                    parent.heightDelta += 1;
                }

                if (parent.heightDelta == 1) {
                    assert parent.left != null;
                } else if (parent.heightDelta == -1) {
                    assert parent.right != null;
                }
                // If the new absolute height difference is 1, then we removed a node
                // from a parent with two children of equal height, so the parent's
                // height does not change.
                if (parent.heightDelta == 1 || parent.heightDelta == -1) return;

                if (parent.heightDelta == 0) {
                    newChild = parent;
                    parent = parent.parent;
                    continue;
                }

                if (parent.heightDelta == 2) {
                    assert parent.right == newChild;
                    Node child = parent.left;
                    if (child.heightDelta >= 0) {
                        // left left case
                        int oldChildHeightDelta = child.heightDelta;
                        rightRotate(parent);
                        if (child.heightDelta == 0) {
                            child.heightDelta = -1;
                            assert child.right != null;
                            parent.heightDelta = 1;
                            assert parent.left != null;
                            if (oldChildHeightDelta == 0) return;
                        } else {
                            child.heightDelta = 0;
                            parent.heightDelta = 0;
                        }
                        newChild = child;
                        parent = newChild.parent;
                    } else {
                        // left right case
                        Node grandchild = child.right;
                        leftRotate(child);
                        rightRotate(parent);
                        if (grandchild.heightDelta == 1) {
                            child.heightDelta = 0;
                            parent.heightDelta = -1;
                        } else if (grandchild.heightDelta == 0) {
                            child.heightDelta = 0;
                            parent.heightDelta = 0;
                        } else if (grandchild.heightDelta == -1) {
                            child.heightDelta = 1;
                            parent.heightDelta = 0;
                        }
                        grandchild.heightDelta = 0;
                        newChild = grandchild;
                        parent = newChild.parent;
                    }
                } else if (parent.heightDelta == -2) {
                    Node child = parent.right;
                    if (child.heightDelta <= 0) {
                        // right right case
                        int oldChildHeightDelta = child.heightDelta;
                        leftRotate(parent);
                        if (child.heightDelta == 0) {
                            child.heightDelta = 1;
                            parent.heightDelta = -1;
                            if (oldChildHeightDelta == 0) return;
                        } else {
                            child.heightDelta = 0;
                            parent.heightDelta = 0;
                        }
                        newChild = child;
                        parent = newChild.parent;
                    } else {
                        // right left case
                        Node grandchild = child.left;
                        rightRotate(child);
                        leftRotate(parent);
                        if (grandchild.heightDelta == -1) {
                            child.heightDelta = 0;
                            parent.heightDelta = 1;
                        } else if (grandchild.heightDelta == 0) {
                            child.heightDelta = 0;
                            parent.heightDelta = 0;
                        } else if (grandchild.heightDelta == 1) {
                            child.heightDelta = -1;
                            parent.heightDelta = 0;
                        }
                        grandchild.heightDelta = 0;
                        newChild = grandchild;
                        parent = newChild.parent;
                    }
                }
            }
        }

        private void rebalanceAdd(Node added) {
            Node parent = null;
            Node middle = added.parent;
            Node child = added;
            if (middle.left == child) {
                middle.heightDelta += 1;
            } else {
                middle.heightDelta -= 1;
            }
            if (middle.heightDelta == 0) return;

            while (middle.parent != null) {
                parent = middle.parent;
                if (parent.left == middle) {
                    parent.heightDelta += 1;
                } else if (parent.right == middle) {
                    parent.heightDelta -= 1;
                }

                // If the new height delta is 0, we've added to the shorter side
                // of the tree, so the height does not change above `parent`.
                if (parent.heightDelta == 0) return;

                if (parent.heightDelta == 2) {
                    if (middle.left == child) {
                        // left left case
                        rightRotate(parent);
                        parent.heightDelta = middle.heightDelta = 0;
                    } else {
                        // left right case
                        leftRotate(middle);
                        rightRotate(parent);
                        if (child.heightDelta == 1) {
                            parent.heightDelta = -1;
                            middle.heightDelta = 0;
                        } else if (child.heightDelta == -1) {
                            parent.heightDelta = 0;
                            middle.heightDelta = 1;
                        } else {
                            parent.heightDelta = middle.heightDelta = 0;
                        }
                        child.heightDelta = 0;
                    }
                    return;
                } else if (parent.heightDelta == -2) {
                    if (middle.right == child) {
                        // right right case
                        leftRotate(parent);
                        parent.heightDelta = middle.heightDelta = 0;
                    } else {
                        // right left case
                        rightRotate(middle);
                        leftRotate(parent);
                        if (child.heightDelta == -1) {
                            parent.heightDelta = 1;
                            middle.heightDelta = 0;
                        } else if (child.heightDelta == 1) {
                            parent.heightDelta = 0;
                            middle.heightDelta = -1;
                        } else {
                            parent.heightDelta = middle.heightDelta = 0;
                        }
                        child.heightDelta = 0;
                    }
                    return;
                }
                child = middle;
                middle = parent;
            }
        }

        private Node floorNode(Integer i) {
            if (root == null) return null;
            Node current = root;
            Node newestRight = null;
            while (true) {
                if (current.value == i) return current;
                if (current.value > i) {
                    if (current.left == null) return newestRight;
                    current = current.left;
                } else {    // value < i
                    if (current.right == null) return current;
                    newestRight = current;
                    current = current.right;
                }
            }
        }

        public boolean add(Integer i) {
            if (root == null) {
                root = new Node(i, null);
                return true;
            }
            Node current = root;
            while (true) {
                if (i > current.value) {
                    if (current.right == null) {
                        current.right = new Node(i, current);
                        rebalanceAdd(current.right);
                        return true;
                    }
                    current = current.right;
                } else if (i < current.value) {
                    if (current.left == null) {
                        current.left = new Node(i, current);
                        rebalanceAdd(current.left);
                        return true;
                    }
                    current = current.left;
                } else {
                    return false;
                }
            }
        }

        // Returns the next largest node in the subtree of `n`, or null if no
        // such node exists.
        private Node nextNode(Node n) {
            if (n.right == null) return null;
            Node next = n.right;
            while (next.left != null) {
                next = next.left;
            }
            return next;
        }

        public boolean remove(Integer i) {
            Node toRemove = floorNode(i);
            if (toRemove == null || toRemove.value != i){
                return false; //The node to be removed doesn't exist.
            }
            if (toRemove.left == null && toRemove.right == null) { // The node to be removed has no children.
                if (toRemove.parent == null) {
                    root = null;
                    return true;
                }
                toRemove.parent.replaceChild(toRemove, null);
                rebalanceRemove(toRemove.parent, null);
                return true;
            }
            if (toRemove.left == null) {        // The node to be removed has a right child but no left child.
                if (toRemove.parent == null) {
                    root = toRemove.right;
                    root.parent = null;
                    return true;
                }
                toRemove.parent.replaceChild(toRemove, toRemove.right);
                rebalanceRemove(toRemove.parent, toRemove.right);
                return true;
            }
            if (toRemove.right == null) {       // The node to be removed has a left child but no right child.
                if (toRemove.parent == null) {
                    root = toRemove.left;
                    root.parent = null;
                    return true;
                }
                toRemove.parent.replaceChild(toRemove, toRemove.left);
                rebalanceRemove(toRemove.parent, toRemove.left);
                return true;
            }
            // The node to be removed has two children.
            Node replacement = nextNode(toRemove); //The replacement can't be null, because toRemove has 2 children.
            toRemove.value = replacement.value;
            replacement.parent.replaceChild(replacement, replacement.right);
            rebalanceRemove(replacement.parent, replacement.right);
            return true;
        }

        public Integer floor(Integer i) {
            Node floor = floorNode(i);
            if (floor == null) return null;
            return floor.value;
        }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int gates = input.nextInt();
        int planes = input.nextInt();
        int[] gateRanges = new int[planes];
        for (int i = 0; i < planes; i++) {
            gateRanges[i] = input.nextInt();
        }

        IntSet emptyGates = new IntBST();
        for (int i = 1; i <= gates; i++) {
            emptyGates.add(i);
        }
        for (int i = 0; i < planes; i++) {
            if (emptyGates.floor(gateRanges[i]) == null) {
                System.out.println(i);
                return;
            }
            emptyGates.remove(emptyGates.floor(gateRanges[i]));
        }
        System.out.println(planes);
    }
}