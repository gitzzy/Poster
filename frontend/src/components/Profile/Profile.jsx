import React from "react";
import KeyboardBackspaceIcon from "@mui/icons-material/KeyboardBackspace";
import { useNavigate } from "react-router-dom";
import { Avatar, Button } from "@mui/material";
import VerifiedIcon from "@mui/icons-material/Verified";

export default function Profile() {
  const navigate = useNavigate();

  const handleBack = () => navigate(-1);
  const handleOpenProfileModel = () => {
    console.log("Changing profile");
  };

  const handleFollowUser = () => {
    console.log("Handling followers");
  };

  return (
    <div>
      <section className={"z-50 flex items-center sticky top-0 bg-opacity-95"}>
        <KeyboardBackspaceIcon
          className="cursor-pointer"
          onClick={handleBack}
        />
        <h1 className="py-5 text-xl font-bold opacity-90 ml-5">
          Devansh Tyagi
        </h1>
      </section>

      <section className="pl-6">
        <img
          src="https://cdn.pixabay.com/index/2025/04/03/05-02-43-324_1440x550.jpg"
          className="w-[90%] h-[15rem] object-cover"
        ></img>
      </section>

      <section>
        <div className="flex justify-between items-start mt-5 h-[5rem] ml-10">
          <Avatar
            className="transform -translate-y-24"
            alt="tyagidevansh"
            src="http://localhost:5173/src/components/assets/avt.webp"
            sx={{ width: "10rem", height: "10rem", border: "4px solid white" }}
          />

          <div className="mr-20">
            {false ? (
              <Button
                className="rounded-full"
                variant="contained"
                onClick={handleOpenProfileModel}
                sx={{ borderRadius: "20px" }}
              >
                Edit Profile
              </Button>
            ) : (
              <Button
                className="rounded-full "
                variant="contained"
                onClick={handleFollowUser}
                sx={{ borderRadius: "20px" }}
              >
                {true ? "Follow" : "Unfollow"}
              </Button>
            )}
          </div>
        </div>
        <div>
          <div className="flex items-center ml-10">
            <h1 className="font-bold text-lg">Devansh Tyagi</h1>
            {true && <VerifiedIcon className="text-[#E2B619] ml-2" />}
          </div>
        </div>
      </section>
    </div>
  );
}
