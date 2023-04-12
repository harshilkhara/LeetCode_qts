/*
Using React 18, create a "Like/Dislike" component for news articles. The component should be the default export (use export default).
Requirements:
You are required to create Like and Dislike buttons following the guidelines below:
Like button
1. The component should render a Like button:
• The button should have the Like-button" class.
• The initial number of likes should be set to 100.
• The text displayed in the Like button should indicate the number of likes in the format Like | 100.
• The number of likes should be wrapped in a «span» element with the className set to "Likes-counter*
2. Clicking the Like button should:
° Increase the number of displayed likes by 1.
• Add the "Liked" class to the Like button's «buttons element.
3. Clicking a Like button that has already been clicked should:
• Decrease the number of displayed likes by 1.
• Remove the liked" class from the Like button's «button» element.
4. Clicking a Like button whose associated Dislike button has already been clicked should
• Increase the number of displayed likes by 1.
• Add the "liked" class to the Like button's button» element.
• Decrease the number of displayed dislikes by 1.
• Remove the disliked" class from the Dislike button's «buttons element.
Dislike button
1. The component should render a Dislike button:
o The button should have the "dislike-button" class.
• The initial number of dislikes should be set to 25.
• The text displayed in the Dislike button should indicate the number of dislikes in the format Dielike | 25.
° The number of dislikes should be wrapped in a «span» element with the className set to "dislikes-counter".
2. Clicking the Dislike button should:
• Increase the number of displayed dislikes by 1.
• Add the "dis11ked" class to the Dislike button's <button» element.
3. Clicking a Dislike button that has already been clicked should:
• Decrease the number of displayed dislikes by 1.
• Remove the "dis11ked" class from the Dislike buttor's «button» element.
4. Clicking a Dislike button whose associated LIke button has already been clicked should:
• Increase the number of displayed dislikes by 1.
• Add the "dis11ked" class to the Dislike button's «button element.
• Decrease the number of displayed likes by 1.
• Remove the "Liked" class from the Like button's «button» element.
Assumptions
• Design/styling is not assessed and will not affect the score. You should focus only on implementing the requirements.
Hints
• Make sure the components have the correct class names as described, with no spelling mistakes (the test will fail even if the logic is correct).
• Use the animation in the Examples section as a reference for your solution.
The Preview tab will display your component. You can use it for testing purposes.
• Use the browser's developer tools in the Preview tab to debug your code (console .10g).
Available packages and libraries
• Only two imports are allowed react (V18.2.0) and classnames (V2.3.1). Both are at the top of the starting code.
*/
import cx from 'classnames';
import React from 'react';

export default () => {
  const [likeCount, setLikeCount] = React.useState(100);
  const [dislikeCount, setDislikeCount] = React.useState(25);
  const [likeClass, setLikeClass] = React.useState('');
  const [dislikeClass, setDislikeClass] = React.useState('');

  const handleLikeClick = () => {
    if (likeClass === '') {
      setLikeCount(likeCount + 1);
      setLikeClass('liked');
    } else {
      setLikeCount(likeCount - 1);
      setLikeClass('');
    }

    if (dislikeClass === 'disliked') {
      setDislikeCount(dislikeCount - 1);
      setDislikeClass('');
    }
  };

  const handleDislikeClick = () => {
    if (dislikeClass === '') {
      setDislikeCount(dislikeCount + 1);
      setDislikeClass('disliked');
    } else {
      setDislikeCount(dislikeCount - 1);
      setDislikeClass('');
    }

    if (likeClass === 'liked') {
      setLikeCount(likeCount - 1);
      setLikeClass('');
    }
  };

  return (
    <>
      <div>
        <button className={cx('like-button', likeClass)} onClick={handleLikeClick}>
          Like | <span className="likes-counter">{likeCount}</span>
        </button>
        <button className={cx('dislike-button', dislikeClass)} onClick={handleDislikeClick}>
          Dislike | <span className="dislikes-counter">{dislikeCount}</span>
        </button>
      </div>
      <style>{`
        .like-button, .dislike-button {
          font-size: 1rem;
          padding: 5px 10px;
          color:   #585858;
        }

        .liked, .disliked {
          font-weight: bold;
          color: #1565c0;
        }
      `}</style>
    </>
  );
};