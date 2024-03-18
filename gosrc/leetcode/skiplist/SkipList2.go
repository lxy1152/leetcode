package main

import (
	"fmt"
	"math/rand"
	"time"
)

// SkipListNode represents a node in the skip list
type SkipListNode struct {
	Value int
	Next  []*SkipListNode // Pointers to next nodes
}

// SkipList represents a skip list data structure
type SkipList struct {
	Head   *SkipListNode
	Levels int // Current number of levels in the skip list
}

// NewSkipListNode creates a new skip list node with provided value and level
func NewSkipListNode(value, level int) *SkipListNode {
	return &SkipListNode{
		Value: value,
		Next:  make([]*SkipListNode, level),
	}
}

// NewSkipList creates a new skip list with a specified number of levels
func NewSkipList(levels int) *SkipList {
	return &SkipList{
		Head:   NewSkipListNode(0, levels),
		Levels: levels,
	}
}

// randomLevel generates a level for the new skip list node
func randomLevel(maxLevel int) int {
	level := 1
	for rand.Float64() < 0.5 && level < maxLevel {
		level++
	}
	return level
}

// Insert inserts a value into the skip list
func (sl *SkipList) Insert(value int) {
	current := sl.Head
	update := make([]*SkipListNode, sl.Levels)

	for i := sl.Levels - 1; i >= 0; i-- {
		for current.Next[i] != nil && current.Next[i].Value < value {
			current = current.Next[i]
		}
		update[i] = current
	}

	current = current.Next[0]
	if current != nil && current.Value == value {
		return // Value already exists; no duplicates allowed
	}

	nodeLevel := randomLevel(sl.Levels)
	newNode := NewSkipListNode(value, nodeLevel)

	for i := 0; i < nodeLevel; i++ {
		newNode.Next[i] = update[i].Next[i]
		update[i].Next[i] = newNode
	}
}

// Search searches for a value in the skip list and returns true if found
func (sl *SkipList) Search(value int) bool {
	current := sl.Head

	for i := sl.Levels - 1; i >= 0; i-- {
		for current.Next[i] != nil && current.Next[i].Value < value {
			current = current.Next[i]
		}
	}

	current = current.Next[0]
	return current != nil && current.Value == value
}

// Print prints the skip list
func (sl *SkipList) Print() {
	for i := 0; i < sl.Levels; i++ {
		current := sl.Head.Next[i]
		fmt.Printf("Level %d: ", i)
		for current != nil {
			fmt.Print(current.Value, " ")
			current = current.Next[i]
		}
		fmt.Println()
	}
}
func main() {
	rand.Seed(time.Now().UnixNano())
	sl := NewSkipList(5)

	sl.Insert(3)
	sl.Insert(6)
	sl.Insert(7)
	sl.Insert(9)
	sl.Insert(12)
	sl.Insert(19)
	sl.Insert(17)
	sl.Insert(26)
	sl.Insert(21)
	sl.Insert(25)

	fmt.Println("Skip List:")
	sl.Print()

	fmt.Println("Search for 9: ", sl.Search(9))
	fmt.Println("Search for 15: ", sl.Search(15))
}
