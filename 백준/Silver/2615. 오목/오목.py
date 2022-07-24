import sys

LENGTH = 19

board = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(19)]

dx, dy = [-1, 0, 1, 1], [1, 1, 1, 0]


def is_in(x, y):
    if 0 <= x < LENGTH and 0 <= y < LENGTH:
        return True
    else:
        return False


def is_omok(x, y, player):
    for k in range(len(dx)):
        bx = x - dx[k]
        by = y - dy[k]
        if not is_in(bx, by) or board[bx][by] != player:
            nx = x + dx[k]
            ny = y + dy[k]
            cnt = 1
            while True:
                if is_in(nx, ny) and board[nx][ny] == player:
                    cnt += 1
                else:
                    break
                nx += dx[k]
                ny += dy[k]
            if cnt == 5:
                return True
    else:
        return False

t = 0
for i in range(LENGTH):
    for j in range(LENGTH):
        if board[i][j] != 0:
            if is_omok(i, j, board[i][j]):
                t = 1
                print(board[i][j])
                print(i+1,j+1)
                break
    if t == 1:
        break
if t == 0:
    print(0)
