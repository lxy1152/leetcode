package main

import "sort"

type players struct {
	players []playert
}

type playert struct {
	score int
	age   int
}

func (this players) Len() int {

	return len(this.players)
}
func (this players) Less(i, j int) bool {
	if this.players[i].age < this.players[j].age || (this.players[i].age == this.players[i].age && this.players[i].score > this.players[j].score) {
		return true
	}
	return false
}
func (this players) Swap(i, j int) {
	temp := this.players[i]
	this.players[i] = this.players[j]
	this.players[j] = temp
}
func bestTeamScore(scores []int, ages []int) int {

	player := make([]playert, len(scores))
	p := players{
		players: player,
	}
	for i := 0; i < len(scores); i++ {
		p.players[i] = playert{
			scores[i], ages[i],
		}
	}
	sort.Sort(p)
	dp := make([]int, len(scores))
	for i := range dp {
		dp[i] = p.players[i].score
	}
	ans := 0
	for i := 0; i < len(scores); i++ {
		for j := 0; j < i; j++ {
			if p.players[j].score <= p.players[i].score {
				dp[i] = max(dp[j]+p.players[i].score, dp[i])
			}
		}
		ans = max(dp[i], ans)
	}

	return ans
}
func max(a, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}

func main() {
	bestTeamScore([]int{9, 2, 8, 8, 2}, []int{4, 1, 3, 3, 5})
}
