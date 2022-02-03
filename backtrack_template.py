def backtrack(candidate):
    if find_solution(candidate):  # goal
        output(candidate)
        return

    # iterate all possible candidates.
    for next_candidate in list_of_candidates:
        if is_valid(next_candidate):                # constraint
            # try this partial candidate solution
            place(next_candidate)                   # choose
            # given the candidate, explore further.
            backtrack(next_candidate)
            # backtrack
            remove(next_candidate)
            