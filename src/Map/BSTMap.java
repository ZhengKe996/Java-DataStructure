package Map;

import BST.BST;

/**
 * 使用BST实现Map
 *
 * @param <K>
 * @param <V>
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {
    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BSTMap() {
        root = null;
        size = 0;
    }

    /**
     * 像以node 为根的二分搜索树中插入元素(key,value),递归
     *
     * @param key
     * @param value
     */
    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value) {

        if (node == null) {
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else
            node.value = value;
        return node;
    }

    /**
     * 返回以node 为根节点的二分搜索树中，key所在的节点
     *
     * @param node
     * @param key
     * @return
     */
    private Node getNode(Node node, K key) {
        if (node == null)
            return null;
        if (key.compareTo(node.key) == 0)
            return node;
        else if (key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else
            return getNode(node.right, key);
    }


    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }


    /**
     * 删除以node为根的二分搜索树中键为key的节点，递归
     *
     * @param key
     * @return
     */
    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key) {
        if (node == null)
            return null;
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {
            // 左子树为空的情况
            if (node.left == null) {
                Node right = node.right;
                node.right = null;
                size--;
                return right;
            }
            // 右子树为空的情况
            if (node.right == null) {
                Node left = node.left;
                node.left = null;
                size--;
                return left;
            }
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            return successor;
        }
    }

    private Node minimum(Node node) {
        if (node.left == null) return node;
        return minimum(node.left);
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(root, key);

        if (node == null)
            throw new IllegalArgumentException(key + "doesn't exits！");
        node.value = value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
