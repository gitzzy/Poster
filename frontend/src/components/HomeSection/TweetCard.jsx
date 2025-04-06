import React from "react";
import RepeatIcon from "@mui/icons-material/Repeat";
import { Avatar, Button } from "@mui/material";
import { useNavigate } from "react-router-dom";
import VerifiedIcon from "@mui/icons-material/Verified";
import MorehorizIcon from "@mui/icons-material/MoreHoriz";
import Menu from "@mui/material/Menu";
import MenuItem from "@mui/material/MenuItem";
import ListItemIcon from "@mui/material/ListItemIcon";
import EditIcon from "@mui/icons-material/Edit";
import DeleteIcon from "@mui/icons-material/Delete";
import Logout from "@mui/icons-material/Logout";
import ChatBubbleOutlineRoundedIcon from "@mui/icons-material/ChatBubbleOutlineRounded";
import RepeatRoundedIcon from "@mui/icons-material/RepeatRounded";
import FavoriteBorderRoundedIcon from "@mui/icons-material/FavoriteBorderRounded";
import RemoveRedEyeRoundedIcon from "@mui/icons-material/RemoveRedEyeRounded";
import IosShareRoundedIcon from "@mui/icons-material/IosShareRounded";
import FavoriteIcon from '@mui/icons-material/Favorite';

export default function TweetCard() {
  const [anchorEl, setAnchorEl] = React.useState(null);
  const open = Boolean(anchorEl);
  const handleClick = (event) => {
    setAnchorEl(event.currentTarget);
  };
  const handleClose = () => {
    setAnchorEl(null);
  };
  const handleDelete = () => {
    console.log("Deleteing post");
    handleClose();
  };
  const handleEdit = () => {
    console.log("editing Post");
    handleClose();
  };

  const handleComment = () => {
    console.log("Comment");
  };

  const [like, setLike] = React.useState(true);
  const handleLike = () => {
    setLike((prevLike) => !prevLike);
    console.log("Like ", like);
  };

  const handleViews = () => {
    console.log("Views");
  };

  const handleShare = () => {
    console.log("handle Share");
  };

  const handleRepost = () => {
    console.log("handle repost");
  };

  const navigate = useNavigate();

  return (
    <div className="">
      <div className="flex items-center font-semibold text-gray-700 py-2 hidden">
        <RepeatIcon />
        <p className="hidden">You reposted</p>
      </div>
      <div className="flex items-center space-x-3">
        {" "}
        {/* Added space-x-3 for space between avatar and name */}
        <Avatar
          alt="username"
          src=""
          className="cursor-pointer"
          onClick={() => navigate(`/profile/${6}`)}
        />
        <div className="flex space-x-2">
          <span className="font-semibold cursor-pointer">Devansh Tyagi</span>
          <span className="text-gray-600 text-sm">@tyagidevansh . 2m</span>
          <VerifiedIcon className="text-[#E2B619]" />
        </div>
        <div>
          <Button
            id="demo-positioned-button"
            aria-controls={open ? "demo-positioned-menu" : undefined}
            aria-haspopup="true"
            aria-expanded={open ? "true" : undefined}
            onClick={handleClick}
          >
            <MorehorizIcon className="ml-30" />
          </Button>
          <Menu
            anchorEl={anchorEl}
            id="account-menu"
            open={open}
            onClose={handleClose}
            onClick={handleClose}
            slotProps={{
              paper: {
                elevation: 0,
                sx: {
                  overflow: "visible",
                  filter: "drop-shadow(0px 2px 8px rgba(0,0,0,0.32))",
                  mt: 1.5,
                  "& .MuiAvatar-root": {
                    width: 32,
                    height: 32,
                    ml: -0.5,
                    mr: 1,
                  },
                  "&::before": {
                    content: '""',
                    display: "block",
                    position: "absolute",
                    top: 0,
                    right: 14,
                    width: 10,
                    height: 10,
                    bgcolor: "background.paper",
                    transform: "translateY(-50%) rotate(45deg)",
                    zIndex: 0,
                  },
                },
              },
            }}
            transformOrigin={{ horizontal: "right", vertical: "top" }}
            anchorOrigin={{ horizontal: "right", vertical: "bottom" }}
          >
            <MenuItem onClick={handleEdit}>
              <ListItemIcon>
                <EditIcon fontSize="small" />
              </ListItemIcon>
              Edit Post
            </MenuItem>
            <MenuItem onClick={handleDelete}>
              <ListItemIcon>
                <DeleteIcon fontSize="small" />
              </ListItemIcon>
              Delete Post
            </MenuItem>
          </Menu>
        </div>
      </div>
      <div className="mt-2 ml-15">
  {/* Image + caption */}
  <div className="w-[28rem]">
    <p className="mb-2">This is Sample tweet</p>
    <img
      className="w-full border border-gray-400 p-5 rounded-md"
      src="http://localhost:5173/src/components/assets/avt.webp"
      alt=""
    />
  </div>

  {/* Action buttons */}
  <div className="py-5 w-[28rem] flex justify-between items-center text-gray-600">
    <div className="flex items-center space-x-2">
      <ChatBubbleOutlineRoundedIcon
        className="cursor-pointer"
        onClick={handleComment}
      />
      <p>43</p>
    </div>

    <div className="flex items-center space-x-2 text-green-600">
      <RepeatRoundedIcon
        className="cursor-pointer"
        onClick={handleRepost}
      />
      <p>99</p>
    </div>

    <div className="flex items-center space-x-2">
      {like ? (
        <FavoriteBorderRoundedIcon
          className="cursor-pointer"
          onClick={handleLike}
        />
      ) : (
        <FavoriteIcon
          className="text-red-500 cursor-pointer"
          onClick={handleLike}
        />
      )}
      <p>67</p>
    </div>

    <RemoveRedEyeRoundedIcon
      className="cursor-pointer"
      onClick={handleViews}
    />

    <IosShareRoundedIcon
      className="cursor-pointer"
      onClick={handleShare}
    />
  </div>
</div>

      </div>
  );
}
