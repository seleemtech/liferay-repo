import React from 'react';
import '../scss/card.scss';

const Card = (props) => {
    return (
        <>
            <div className="lfr-objects__card">
                <div className="lfr-objects__card-header"><h3 className="lfr-objects__card-title">{props.title}</h3></div>
                <div className="lfr-objects__card-body">
                    {props.children}
                </div>
            </div>
        </>
    );
}
export default Card;