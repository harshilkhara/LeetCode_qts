def normalize_grades(grades):

    def normalize(x):
        z=-1
        z=(x-min_x)/(max_x-min_x)
        return z


    ls=[0]*len(grades)
    i=0
    for name, marks in grades:
        ls[i]=marks
        i+=1 
    
    max_x=max(ls)
    min_x=min(ls)

    i=0
    for marks in ls:
        ls[i]=normalize(marks)
        i+=1
    
    i=0
    for i in range(len(grades)):
        grades[i]=(grades[i][0], round(ls[i],2))
    
    return grades


def normalize_grades1(grades):
    max_grade = max(grade for _, grade in grades)
    min_grade = min(grade for _, grade in grades)
    range_grade = max_grade - min_grade
    return [(name, round(((grade - min_grade) / range_grade),2)) for name, grade in grades]


grades = [
    ('Jason', 94),
    ('Tessa', 80),
    ('Carla', 38),
    ('Matt', 43),
    ('Jessica', 100)
]
print(normalize_grades1(grades))
print(normalize_grades(grades))