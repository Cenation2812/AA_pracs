class Node {
    int data;
    Node parent;
    Node left;
    Node right;
    int color;
}

public class rb {
    public Node root;
    public Node NULL;

    public void inOrderHelper(Node node) {
        int i = 0;
        if (node != NULL) {
            System.out.println(node.data + " ");
            inOrderHelper(node.left, "L", i);
            inOrderHelper(node.right, "R", i);
        }
    }

    public void inOrderHelper(Node node, String str, int i) {
        if (node != NULL) {
            i++;
            System.out.println(node.data + " (" + str + "" + i + ") " );
            inOrderHelper(node.left, "L", i);
            inOrderHelper(node.right, "R", i);
        }
    }

    public void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != NULL) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    public void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != NULL) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    public void fixInsert(Node k) {
        Node u;
        while (k.parent.color == 1) {
            if (k.parent == k.parent.parent.right) {
                u = k.parent.parent.left;
                if (u.color == 1) {
                    u.color = 0;
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        k = k.parent;
                        rightRotate(k);
                    }
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    leftRotate(k.parent.parent);
                }
            } else {
                u = k.parent.parent.right;

                if (u.color == 1) {
                    u.color = 0;
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {
                        k = k.parent;
                        leftRotate(k);
                    }
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    rightRotate(k.parent.parent);
                }
            }
            if (k == root) {
                break;
            }
        }
        root.color = 0;
    }

    public void insert(int key) {
        Node node = new Node();
        node.parent = null;
        node.data = key;
        node.left = NULL;
        node.right = NULL;
        node.color = 1;

        Node y = null;
        Node x = this.root;

        while (x != NULL) {
            y = x;
            if (node.data < x.data) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        node.parent = y;
        if (y == null) {
            root = node;
        } else if (node.data < y.data) {
            y.left = node;
        } else {
            y.right = node;
        }

        if (node.parent == null) {
            node.color = 0;
            return;
        }

        if (node.parent.parent == null) {
            return;
        }

        fixInsert(node);
    }

    public Node getRoot() {
        return this.root;
    }

    private void printHelper(Node root, String indent, boolean last) {
        if (root != NULL) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }

            String sColor = root.color == 1 ? "RED" : "BLACK";
            System.out.println(root.data + "(" + sColor + ")");
            printHelper(root.left, indent, false);
            printHelper(root.right, indent, true);
        }
    }

    public void printTree() {
        // printHelper(this.root, "", true);
        inOrderHelper(this.root);
    }

    public rb() {
        NULL = new Node();
        NULL.color = 0;
        NULL.left = null;
        NULL.right = null;
        root = NULL;
    }

    public static void main(String[] args) {
        rb rbtree = new rb();
        rbtree.insert(10);
        rbtree.insert(20);
        rbtree.insert(3);
        rbtree.insert(7);
        rbtree.insert(1);
        rbtree.insert(22);
        rbtree.insert(21);
        rbtree.insert(6);
        rbtree.insert(30);
        rbtree.insert(45);
        rbtree.printTree();
    }

}